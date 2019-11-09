package site.radekszostak.cvrepository.service;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class PhotoServiceImpl implements PhotoService {

	@Value("${storage.userphotos}")
	private String storageLocation;

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	@Override
	public void store(byte[] bytes, String name) throws Exception {

		BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));

		int height = image.getHeight();
		int width = image.getWidth();

		if (height != width) {
			int x, y, w, h;
			if (height > width) {
				x = 0;
				y = height / 2 - width / 2;
				w = width;
				h = width;
			} else {
				x = width / 2 - height / 2;
				y = 0;
				w = height;
				h = height;
			}
			image = image.getSubimage(x, y, w, h);
		}
		int squareSize = Math.min(image.getWidth(), image.getHeight());
		int targetSize = 500;
		if (squareSize > targetSize) {
			BufferedImage resizedImage = new BufferedImage(targetSize, targetSize, image.getType());
			Graphics2D g = resizedImage.createGraphics();

			g.drawImage(image, 0, 0, targetSize, targetSize, null);
			g.dispose();
			g.setComposite(AlphaComposite.Src);
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			image = resizedImage;
		}
		Path path = Paths.get(storageLocation, name);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", baos);
		Files.write(path, baos.toByteArray());

	}

	@Override
	public Stream<Path> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] load(String filename) {
		Path path = Paths.get(storageLocation, filename);
		byte[] file;
		try {
			file = Files.readAllBytes(path);
		} catch (IOException e) {
			file = null;
		}
		return file;
	}

	@Override
	public Resource loadAsResource(String filename) {

		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun drawLines(): BufferedImage {
    // Add your code here
    val width = 200
    val height = 200

    val image = BufferedImage(height, width, BufferedImage.TYPE_INT_RGB)
    for (i in 0 until image.height) {
        for (j in 0 until  image.width) {
            when {
                i + j == 200 -> image.setRGB(j, i, Color.green.rgb)
                i == j -> image.setRGB(j, i, Color.red.rgb)
            }
        }
    }

    return image
}

fun drawLinesByGraphics(): BufferedImage {
    // Add your code here
    val width = 200
    val height = 200

    val image = BufferedImage(height, width, BufferedImage.TYPE_INT_RGB)

    val graphics = image.graphics
    graphics.color = Color.red
    graphics.drawLine(0, 0, 200, 200)
    graphics.color = Color.green
    graphics.drawLine(200, 0, 0, 200)

    return image
}

fun main() {
    val file = File("rgb.png")
    ImageIO.write(drawLinesByGraphics(), "png", file)
}
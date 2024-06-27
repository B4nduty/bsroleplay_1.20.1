package banduty.bsroleplay.screen.button;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class TexturedButton extends ButtonWidget {
    private final Identifier buttonTexture;
    private final Identifier hoverTexture;

    public TexturedButton(int x, int y, int width, int height, PressAction onPress, Identifier buttonTexture, Identifier hoverTexture) {
        super(x, y, width, height, Text.literal(""), onPress, ButtonWidget.DEFAULT_NARRATION_SUPPLIER);
        this.buttonTexture = buttonTexture;
        this.hoverTexture = hoverTexture;
    }

    @Override
    protected void renderButton(DrawContext context, int mouseX, int mouseY, float delta) {
        Identifier texture = this.isHovered() ? hoverTexture : buttonTexture;
        MinecraftClient.getInstance().getTextureManager().bindTexture(texture);
        context.drawTexture(texture, this.getX(), this.getY(), 0, 0, this.width, this.height, this.width, this.height);
    }
}
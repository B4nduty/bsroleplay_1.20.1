
package banduty.bsroleplay.screen;

import banduty.bsroleplay.BsRolePlay;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;

@Environment(EnvType.CLIENT)
public class WalletScreen extends HandledScreen<WalletScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/gui/wallet_gui.png");
    private static final Identifier TEXTURE_OVERLAY = new Identifier(BsRolePlay.MOD_ID, "textures/gui/wallet_gui_overlay.png");

    public WalletScreen(WalletScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 194;
        this.backgroundHeight = 165;
        this.playerInventoryTitleY = 1000;
        this.titleY = 1000;
    }


    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        context.drawTexture(TEXTURE_OVERLAY, this.x - 10, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight);
        int color = this.handler.getColor();
        var r = ColorHelper.Argb.getRed(color);
        var g = ColorHelper.Argb.getGreen(color);
        var b = ColorHelper.Argb.getBlue(color);
        context.setShaderColor((float) r / 375, (float) g / 375, (float) b / 375, 0);
        context.drawTexture(TEXTURE, this.x - 10, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, Text.literal(this.handler.getCurrencyAmount() + " RP"), this.x + 142, this.y + 12, 0xffffff);
        context.drawCenteredTextWithShadow(this.textRenderer, Text.literal("Wallet"), this.x + 52, this.y + 10, 0xffffff);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}

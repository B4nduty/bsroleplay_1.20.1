
package banduty.bsroleplay.screen.creative_shop;

import banduty.bsroleplay.BsRolePlay;
import banduty.bsroleplay.networking.ModMessages;
import banduty.bsroleplay.screen.button.TexturedButton;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CreativeShopScreen extends HandledScreen<CreativeShopScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/gui/creative_shop_gui.png");
    private static final Identifier INCREASE_BUTTON_TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/gui/increase.png");
    private static final Identifier INCREASE_BUTTON_HOVER_TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/gui/increase_hover.png");
    private static final Identifier INCREASE_100_BUTTON_TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/gui/increase_100.png");
    private static final Identifier INCREASE_100_BUTTON_HOVER_TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/gui/increase_100_hover.png");
    private static final Identifier INCREASE_1K_BUTTON_TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/gui/increase_1k.png");
    private static final Identifier INCREASE_1K_BUTTON_HOVER_TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/gui/increase_1k_hover.png");
    private static final Identifier DECREASE_BUTTON_TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/gui/decrease.png");
    private static final Identifier DECREASE_BUTTON_HOVER_TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/gui/decrease_hover.png");
    private static final Identifier DECREASE_100_BUTTON_TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/gui/decrease_100.png");
    private static final Identifier DECREASE_100_BUTTON_HOVER_TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/gui/decrease_100_hover.png");
    private static final Identifier DECREASE_1K_BUTTON_TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/gui/decrease_1k.png");
    private static final Identifier DECREASE_1K_BUTTON_HOVER_TEXTURE = new Identifier(BsRolePlay.MOD_ID, "textures/gui/decrease_1k_hover.png");

    public CreativeShopScreen(CreativeShopScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 194;
        this.backgroundHeight = 165;
        this.playerInventoryTitleY = 1000;
        this.titleY = 1000;
    }

    @Override
    protected void init() {
        TexturedButton increase1Button = new TexturedButton(this.width / 2 - 77, this.height / 2 - 47, 16, 16,
                button -> sendCurrencyUpdatePacket(1), INCREASE_BUTTON_TEXTURE, INCREASE_BUTTON_HOVER_TEXTURE);

        TexturedButton increase100Button = new TexturedButton(this.width / 2 - 77, this.height / 2 - 62, 16, 16,
                button -> sendCurrencyUpdatePacket(100), INCREASE_100_BUTTON_TEXTURE, INCREASE_100_BUTTON_HOVER_TEXTURE);

        TexturedButton increase10KButton = new TexturedButton(this.width / 2 - 77, this.height / 2 - 77, 16, 16,
                button -> sendCurrencyUpdatePacket(1000), INCREASE_1K_BUTTON_TEXTURE, INCREASE_1K_BUTTON_HOVER_TEXTURE);

        TexturedButton decrease1Button = new TexturedButton(this.width / 2 + 43, this.height / 2 - 47, 16, 16,
                button -> sendCurrencyUpdatePacket(-1), DECREASE_BUTTON_TEXTURE, DECREASE_BUTTON_HOVER_TEXTURE);

        TexturedButton decrease100Button = new TexturedButton(this.width / 2 + 43, this.height / 2 - 62, 16, 16,
                button -> sendCurrencyUpdatePacket(-100), DECREASE_100_BUTTON_TEXTURE, DECREASE_100_BUTTON_HOVER_TEXTURE);

        TexturedButton decrease10KButton = new TexturedButton(this.width / 2 + 43, this.height / 2 - 77, 16, 16,
                button -> sendCurrencyUpdatePacket(-1000), DECREASE_1K_BUTTON_TEXTURE, DECREASE_1K_BUTTON_HOVER_TEXTURE);

        this.addDrawableChild(increase1Button);
        this.addDrawableChild(increase100Button);
        this.addDrawableChild(increase10KButton);
        this.addDrawableChild(decrease1Button);
        this.addDrawableChild(decrease100Button);
        this.addDrawableChild(decrease10KButton);
        super.init();
    }

    private void sendCurrencyUpdatePacket(int amount) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeInt(this.handler.syncId);
        buf.writeInt(amount);
        ClientPlayNetworking.send(ModMessages.CURRENCY_COUNTER_ID, buf);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        context.drawTexture(TEXTURE, this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, Text.literal(this.handler.getCurrencyAmount() + " RP"), this.x + 90, this.y + 39, 0xffffff);
        context.drawCenteredTextWithShadow(this.textRenderer, Text.literal("Creative Shop"), this.x + 88, this.y + 15, 0xffffff);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}


package banduty.bsroleplay.block.custom.coins;

import banduty.bsroleplay.block.ModBlocks;
import banduty.bsroleplay.block.entity.coins.AmethystCoinBlockEntity;
import banduty.bsroleplay.block.entity.coins.CopperCoinBlockEntity;
import banduty.bsroleplay.block.entity.coins.GoldCoinBlockEntity;
import banduty.bsroleplay.block.entity.coins.NetheriteCoinBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class CoinBlock extends BlockWithEntity {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    protected static final VoxelShape SHAPE = createCuboidShape(5.0, 0.0, 5.0, 11.0, 1.0, 11.0);

    public CoinBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    @SuppressWarnings("deprecation")
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        if (state.getBlock() == ModBlocks.COPPER_COIN) return new CopperCoinBlockEntity(pos, state);
        if (state.getBlock() == ModBlocks.GOLD_COIN) return new GoldCoinBlockEntity(pos, state);
        if (state.getBlock() == ModBlocks.AMETHYST_COIN) return new AmethystCoinBlockEntity(pos, state);
        if (state.getBlock() == ModBlocks.NETHERITE_COIN) return new NetheriteCoinBlockEntity(pos, state);
        return new CopperCoinBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}

package banduty.bsroleplay.block.custom;

import banduty.bsroleplay.block.entity.TinyBandutyEntity;
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

public class TinyBanduty extends BlockWithEntity {

    public TinyBanduty(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }
    protected static final VoxelShape TINY;
    protected static final VoxelShape WEAST_TINY;
    protected static final VoxelShape TINY_COLLISION;
    protected static final VoxelShape TINY_COLLISION_WEAST;
    public static final DirectionProperty FACING;

    static {
        WEAST_TINY = Block.createCuboidShape(6.0, 0.0, 0.0, 10.0, 16.0, 16.0);
        TINY = Block.createCuboidShape(0.0, 0.0, 6.0, 16.0, 16.0, 10.0);
        TINY_COLLISION_WEAST = Block.createCuboidShape(3.0, 0.0, 0.0, 13.0, 27.0, 16.0);
        TINY_COLLISION = Block.createCuboidShape(0.0, 0.0, 3.0, 16.0, 27.0, 13.0);
        FACING = HorizontalFacingBlock.FACING;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case EAST, WEST -> WEAST_TINY;
            default -> TINY;
        };
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case EAST, WEST -> TINY_COLLISION_WEAST;
            default -> TINY_COLLISION;
        };
    }

    @Override
    public VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case EAST, WEST -> TINY_COLLISION_WEAST;
            default -> TINY_COLLISION;
        };
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TinyBandutyEntity(pos, state);
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}

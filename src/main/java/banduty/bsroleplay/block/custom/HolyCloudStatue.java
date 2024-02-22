package banduty.bsroleplay.block.custom;

import banduty.bsroleplay.block.entity.HolyCloudStatueEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class HolyCloudStatue extends BlockWithEntity {

    public HolyCloudStatue(Settings settings) {
        super(settings);
    }

    protected static final VoxelShape BASE;
    protected static final VoxelShape WOOD;
    protected static final VoxelShape HEAD;
    protected static final VoxelShape BODY_1;
    protected static final VoxelShape BODY_2;
    protected static final VoxelShape TAIL;
    protected static final VoxelShape HOLY_CLOUD_STATUE;

    static {
        BASE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 5.0, 16.0);
        WOOD = Block.createCuboidShape(7.0, 5.0, 5.0, 9.0, 29.0, 7.0);
        HEAD = Block.createCuboidShape(1.0, 31.0, -10.0, 15.0, 42.0, 2.0);
        BODY_1 = Block.createCuboidShape(0.0, 29.0, 1.0, 16.0, 33.0, 13.0);
        BODY_2 = Block.createCuboidShape(0.0, 20.0, 13.0, 16.0, 29.0, 20.0);
        TAIL = Block.createCuboidShape(2.0, 12.0, 14.0, 12.0, 20.0, 20.0);
        HOLY_CLOUD_STATUE = VoxelShapes.union(BASE, WOOD, HEAD, BODY_1, BODY_2, TAIL);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BASE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return HOLY_CLOUD_STATUE;
    }

    @Override
    public VoxelShape getCameraCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return HOLY_CLOUD_STATUE;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new HolyCloudStatueEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}

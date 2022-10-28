package hibi.blahaj.mixinreplacement;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IArmPoseTransformer;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class HumanoidModelReplacement {
	public static void consume(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new CuddlyItemExtension());
	}

	private static class CuddlyItemExtension implements IClientItemExtensions {

		private static HumanoidModel.ArmPose pose = HumanoidModel.ArmPose.create("blahaj_arm_pose", true, new CuddlyArmTransformer());

		@Override
		public HumanoidModel.@Nullable ArmPose getArmPose(LivingEntity entityLiving, InteractionHand hand, ItemStack itemStack) {
			return pose;
		}
	}

	private static class CuddlyArmTransformer implements IArmPoseTransformer {

		@Override
		public void applyTransform(HumanoidModel<?> model, LivingEntity entity, HumanoidArm arm) {
			model.rightArm.xRot = -0.95F;
			model.rightArm.yRot = (float) (-Math.PI / 8);
			model.leftArm.xRot = -0.90F;
			model.leftArm.yRot = (float) (Math.PI / 8);
		}
	}
}

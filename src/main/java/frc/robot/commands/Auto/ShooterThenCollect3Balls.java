// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Trajectories;
import frc.robot.commands.ShootBalls;
import frc.robot.subsystems.drivetrain.states.PathFollowerState;
import frc.robot.subsystems.intake.states.CollectState;
import frc.robot.subsystems.intake.states.StowState;

public class ShooterThenCollect3Balls extends SequentialCommandGroup {
  public ShooterThenCollect3Balls() {
    addCommands(
      new ShootBalls().withTimeout(5),
      race(
        new CollectState(),
        new PathFollowerState(Trajectories.testTraj0)
      ),
      race(
        new StowState(),
        new PathFollowerState(Trajectories.testTraj1)
      ),
      new ShootBalls()
    );
  }
}

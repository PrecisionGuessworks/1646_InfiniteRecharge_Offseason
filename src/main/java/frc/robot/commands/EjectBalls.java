// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.TurretConstants;
import frc.robot.subsystems.hopper.states.FeedState;
import frc.robot.subsystems.intake.states.CollectState;
import frc.robot.subsystems.shooter.states.EjectState;
import frc.robot.subsystems.turret.states.PositionState;

public class EjectBalls extends SequentialCommandGroup {
  public EjectBalls() {
    addCommands(
      new PositionState(TurretConstants.EJECT_ANGLE_IN_RADIANS),
      parallel(
        new EjectState(),
        new FeedState()
      )
    );
  }
}

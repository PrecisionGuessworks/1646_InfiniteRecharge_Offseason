/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.shooter.states;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.shooter.ShooterSubsystem;

public class LongShotState extends CommandBase {
  
  ShooterSubsystem shooter = ShooterSubsystem.getInstance();

  public LongShotState() {
    addRequirements(shooter);
  }

  @Override
  public void initialize() {
    shooter.setPower(ShooterConstants.LONG_SHOT_POWER);
  }
}

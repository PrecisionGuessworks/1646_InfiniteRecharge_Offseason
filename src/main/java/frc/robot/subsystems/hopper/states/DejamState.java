/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.hopper.states;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.HopperConstants;
import frc.robot.subsystems.hopper.HopperSubsystem;

public class DejamState extends CommandBase {
  
  HopperSubsystem hopper = HopperSubsystem.getInstance();

  public DejamState() {
    addRequirements(hopper);
  }

  @Override
  public void initialize() {
    hopper.setFeederWheelPowerTo(HopperConstants.elevatorDejamPower);
    hopper.setDejamWheelPowerTo(HopperConstants.dejamPower);
  }

}

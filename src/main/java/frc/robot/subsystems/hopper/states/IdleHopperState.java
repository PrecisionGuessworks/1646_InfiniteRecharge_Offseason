/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.hopper.states;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.hopper.HopperSubsystem;

public class IdleHopperState extends CommandBase {

  HopperSubsystem hopper = HopperSubsystem.getInstance();

  public IdleHopperState() {
    addRequirements(hopper);
  }

  @Override
  public void initialize() {
    hopper.setDejamWheelPowerTo(0.0);
    hopper.setFeederWheelPowerTo(0.0);
  }
}

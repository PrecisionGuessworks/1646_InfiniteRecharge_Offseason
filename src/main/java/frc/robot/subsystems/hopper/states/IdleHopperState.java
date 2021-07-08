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
  /**
   * Creates a new IdleHopperState.
   */
  HopperSubsystem hopper = HopperSubsystem.getInstance();

  public IdleHopperState() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(hopper);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    hopper.setDejamWheelPowerTo(0.0);
    hopper.setFeederWheelPowerTo(0.0);
  }
}

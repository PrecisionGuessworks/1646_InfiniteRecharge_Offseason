// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.intake.states;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Controllers;
import frc.robot.Controllers.PS4_Controller.Axis;
import frc.robot.subsystems.intake.IntakeSubsystem;

public class Manual extends CommandBase {
  
  IntakeSubsystem intake = IntakeSubsystem.getInstance();

  public Manual() {
    addRequirements(intake);
  }


  @Override
  public void execute() {
    double power = Controllers.getOperatorController().getRawAxis(Controllers.PS4_Controller.Axis.RIGHT_STICK_Y);
    intake.setArmPower(power);
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.intake.states;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.Constants.IntakeConstants;

public class CollectState extends CommandBase {

  private IntakeSubsystem intake = IntakeSubsystem.getInstance();

  public CollectState() {
    addRequirements(intake);
  }


  @Override
  public void initialize() {
    intake.setRollerPower(IntakeConstants.rollerIntakePower);
    
  }

  @Override
  public void execute() {
    intake.extend();
  }
}

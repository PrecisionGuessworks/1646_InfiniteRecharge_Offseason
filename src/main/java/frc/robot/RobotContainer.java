/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Controllers.PS4_Controller.Button;
import frc.robot.commands.EjectBalls;
import frc.robot.commands.PrecisionShot;
import frc.robot.commands.ShootBalls;
import frc.robot.subsystems.drivetrain.DrivetrainSubsystem;
import frc.robot.subsystems.drivetrain.states.DriveForwardState;
import frc.robot.subsystems.drivetrain.states.OpenLoopState;
import frc.robot.subsystems.hopper.HopperSubsystem;
import frc.robot.subsystems.hopper.states.IdleHopperState;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.intake.states.CollectState;
import frc.robot.subsystems.intake.states.StowState;
import frc.robot.subsystems.shooter.ShooterSubsystem;
import frc.robot.subsystems.shooter.states.IdleShooterState;
import frc.robot.subsystems.turret.TurretSubsystem;
import frc.robot.subsystems.turret.states.IdleTurretState;
import frc.robot.subsystems.turret.states.PositionState;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  DrivetrainSubsystem drive;
  ShooterSubsystem shooter;
  IntakeSubsystem intake;
  HopperSubsystem hopper;
  TurretSubsystem turret;

  private final DriveForwardState autoCommand = new DriveForwardState(Constants.DrivetrainConstants.autoDriveTime);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    initalizeSubsystems();

    setAllDefaultCommands();

    configureButtonBindings();
  }

  private void initalizeSubsystems(){
    drive = DrivetrainSubsystem.getInstance();
    shooter = ShooterSubsystem.getInstance();
    intake = IntakeSubsystem.getInstance();
    hopper = HopperSubsystem.getInstance();
    turret = TurretSubsystem.getInstance();
  }

  private void setAllDefaultCommands(){
    CommandScheduler.getInstance().setDefaultCommand(drive, new OpenLoopState());
    CommandScheduler.getInstance().setDefaultCommand(shooter, new IdleShooterState());
    CommandScheduler.getInstance().setDefaultCommand(intake, new StowState());
    CommandScheduler.getInstance().setDefaultCommand(hopper, new IdleHopperState());
    CommandScheduler.getInstance().setDefaultCommand(turret, new IdleTurretState());
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    configureDriverButtonBindings();
    configureOperatorButtonBindings();
  }

  private void configureDriverButtonBindings() {
    Joystick drive_joystick = Controllers.getDriverController();

    new JoystickButton(drive_joystick, Button.TRIANGLE).whileHeld(new EjectBalls());
    new JoystickButton(drive_joystick, Button.X).whileHeld(new CollectState());
    new JoystickButton(drive_joystick, Button.L1).whileHeld(new ShootBalls());
    new JoystickButton(drive_joystick, Button.R1).whileHeld(new PrecisionShot());
    new JoystickButton(drive_joystick, Button.CIRCLE).whenHeld(new PositionState(0));
  }

  private void configureOperatorButtonBindings() {
    Joystick op_joystick = Controllers.getOperatorController();

    new JoystickButton(op_joystick, Button.TRIANGLE).whileHeld(new EjectBalls());
    new JoystickButton(op_joystick, Button.X).whileHeld(new CollectState());
    new JoystickButton(op_joystick, Button.L1).whileHeld(new ShootBalls());
    new JoystickButton(op_joystick, Button.R1).whileHeld(new PrecisionShot());
    new JoystickButton(op_joystick, Button.CIRCLE).whenHeld(new PositionState(0));
  }

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    
    return autoCommand;//second
  }
}

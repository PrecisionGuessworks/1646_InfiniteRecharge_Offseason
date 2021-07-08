/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.hopper;

import javax.swing.tree.RowMapper;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import sun.security.jca.GetInstance;

public class HopperSubsystem extends SubsystemBase {

  private VictorSP feederWheelMotor;
  private VictorSP dejamWheelMotor;

  private HopperSubsystem instance;
  /**
   * Creates a new HopperSubsystem.
   */
  private HopperSubsystem() {
    feederWheelMotor = new VictorSP(RobotMap.HOPPER_FEEDER_WHEEL_MOTOR_ID);
    dejamWheelMotor = new VictorSP(RobotMap.HOPPER_DEJAM_WHEEL_MOTOR_ID);
  }

  public HopperSubsystem getInstance(){
    if (instance == null){
        instance = new HopperSubsystem();
    }
    return instance;
  }

  public void setFeederWheelPowerTo(double power){
    feederWheelMotor.set(power);
  }

  public void setDejamWheelPowerTo(double power){
    dejamWheelMotor.set(power);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

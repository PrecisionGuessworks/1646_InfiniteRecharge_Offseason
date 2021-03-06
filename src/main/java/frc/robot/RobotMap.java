/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants for motor ids.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class RobotMap {
    public static final int DRIVETRAIN_FR_MOTOR_ID = 01;
    public static final int DRIVETRAIN_FL_MOTOR_ID = 02;
    public static final int DRIVETRAIN_BR_MOTOR_ID = 03;
    public static final int DRIVETRAIN_BL_MOTOR_ID = 04;
    public static final int DRIVETRAIN_TR_MOTOR_ID = 05;
    public static final int DRIVETRAIN_TL_MOTOR_ID = 06;


    public static final int INTAKE_ROLLER_MOTOR_ID = 11;
    public static final int INTAKE_ARM_MOTOR_ID = 12;
    public static final int INTAKE_ARM_ENCODE_CHANNEL_A = 01;
    public static final int INTAKE_ARM_ENCODE_CHANNEL_B = 02;

    public static final int HOPPER_FEEDER_WHEEL_MOTOR_ID = 21;
    public static final int HOPPER_DEJAM_WHEEL_MOTOR_ID = 22;

    public static final int SHOOTER_UPPER_MOTOR_ID = 31;
    public static final int SHOOTER_LOWER_MOTOR_ID = 32;

    public static final int TURRERT_MOTOR_ID = 40;

    public static final int DRIVER_CONTROLLER_ID = 00;
    public static final int OPERATOR_CONTROLLER_ID = 01;
}

package frc.robot;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;

public class Trajectories {
    private static final List<Pose2d> POINT_LIST_0 = List.of(FieldPositions.START, 
                                                            FieldPositions.addRotation(FieldPositions.pointAtIntake(FieldPositions.TRENCH_CELL_3), new Rotation2d()));

    
    private static final List<Pose2d> POINT_LIST_1 = List.of(FieldPositions.addRotation(FieldPositions.TRENCH_CELL_3, new Rotation2d()), 
                                                            FieldPositions.OPPSHOT);

    public static final Trajectory testTraj0 = TrajectoryGenerator.generateTrajectory(POINT_LIST_0, new TrajectoryConfig(10, 23).setReversed(false));
    public static final Trajectory testTraj1 = TrajectoryGenerator.generateTrajectory(POINT_LIST_1, new TrajectoryConfig(10, 23).setReversed(true));

    
}
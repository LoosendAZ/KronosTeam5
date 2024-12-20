package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.*;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.*;
import com.ctre.phoenix6.swerve.SwerveModule;

import frc.Constants;


public class Swervedrive extends SubsystemBase{

    private static Swervedrive swervedrive;

    //4 Talon FXs?

    private TalonFX m_DriveTopLeft;
    private TalonFX m_DriveTopRight;
    private TalonFX m_DriveBottomLeft;
    private TalonFX m_DriveBottomRight;

    //Or 4 SwerveModules?

    private SwerveModule swerveTopLeft;
    private SwerveModule swerveTopRight;
    private SwerveModule swerveBottomLeft;
    private SwerveModule swerveBottomRight;

    public static Swervedrive getInstance() {
        if(swervedrive == null) {
            swervedrive = new Swervedrive();
        }
        return swervedrive;
    }

    public Swervedrive() {
        
        //[placeholders]
        m_DriveBottomLeft = new TalonFX(0);
        m_DriveBottomRight = new TalonFX(0);
        m_DriveTopLeft = new TalonFX(0);
        m_DriveTopRight = new TalonFX(0);

        //or [placeholders]
        swerveBottomLeft = new SwerveModule(null, getName(), 0, 0);
        swerveBottomRight = new SwerveModule(null, getName(), 0, 0);
        swerveTopLeft = new SwerveModule(null, getName(), 0, 0);
        swerveTopRight = new SwerveModule(null, getName(), 0, 0);

        
    }

}

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.Supplier;

import com.ctre.phoenix6.*;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.*;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.swerve.SwerveModule;
import com.ctre.phoenix6.swerve.SwerveRequest;
import java.util.function.Supplier;

import com.ctre.phoenix6.mechanisms.swerve.*;

import frc.Constants;


public class Swervedrive extends SubsystemBase{

    private static Swervedrive swervedrive;

    //Or 4 SwerveModules?

    private SwerveModule swerveTopLeft;
    private SwerveModule swerveTopRight;
    private SwerveModule swerveBottomLeft;
    private SwerveModule swerveBottomRight;

    private SwerveModule[] modules;

    public static Swervedrive getInstance() {
        if(swervedrive == null) {
            swervedrive = new Swervedrive();
        }
        return swervedrive;
    }

    public Swervedrive() {
        //or [placeholders]
        swerveBottomLeft = new SwerveModule(null, getName(), 0, 0);
        swerveBottomRight = new SwerveModule(null, getName(), 0, 0);
        swerveTopLeft = new SwerveModule(null, getName(), 0, 0);
        swerveTopRight = new SwerveModule(null, getName(), 0, 0);

        modules = new SwerveModule[4];
        modules[0] = swerveBottomLeft;
        modules[1] = swerveBottomRight;
        modules[2] = swerveTopLeft;
        modules[3] = swerveTopRight;
    }

    private void configMotor(SwerveModule[] s) {
        for (SwerveModule swerve : s) {
            CurrentLimitsConfigs currentConfigs = new CurrentLimitsConfigs();    
            currentConfigs.SupplyCurrentLimit = 0.0; //PLACEHOLDER
            swerve.getDriveMotor().getConfigurator().apply(currentConfigs);
            swerve.getSteerMotor().getConfigurator().apply(currentConfigs);
        }
    }

    public void move() {
        for (SwerveModule swerve : this.modules) {
            //FIX THIS
            swerve.getDriveMotor().set(0.0);
            swerve.getSteerMotor().set(0.0);
        }
    }

    public SwerveModule[] getModules() {
        return this.modules;
    }
}

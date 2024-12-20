package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.*;
import com.ctre.phoenix6.hardware.*;

import frc.Constants;
import frc.robot.Subsystems.Indexer.IndexerStates;

public class Shooter extends SubsystemBase{
    private static Shooter s_Shooter;

    private TalonFX m_Shooter;
    private TalonFX m_ShooterReverse;


    public static Shooter getInstance() {
        if(s_Shooter == null) {
            s_Shooter = new Shooter();
        }
        return s_Shooter;
    }
    public Shooter() {
        m_Shooter = new TalonFX(Constants.HardwarePorts.m_Shooter);
        m_ShooterReverse = new TalonFX(Constants.HardwarePorts.m_ShooterReverse);
        m_ShooterReverse.setInverted(true);
    }

    //All values are arbitrary for now feel free to change
    public enum ShooterStates {
        ON(1.0),
        OFF(0.0),
        REVERSE(-1.0);

        private double speed;

        private ShooterStates(double state) {
            this.speed = state;
        }

        public double getSpeed() {
            return this.speed;
        }
    }
    
    public void setSpeed(ShooterStates state) {
        //Arbitrary value
        m_Shooter.set(state.getSpeed());
    }

    public void setVoltage(double voltage) {
        m_Shooter.setVoltage(voltage);
    }

    // public void shoot() {
    //     m_Shooter.setVoltage(15);
    //     m_Shooter.set(20);
    // }

    // public void stop() {
    //     m_Shooter.setVoltage(0.0);
    //     m_Shooter.set(0);
    //     m_Shooter.stopMotor();
    // }

    public void periodic() {
        SmartDashboard.putData("Shooter motor", m_Shooter);
    }
}

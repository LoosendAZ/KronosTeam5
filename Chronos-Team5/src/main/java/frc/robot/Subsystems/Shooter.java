package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.*;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.*;
import com.ctre.phoenix6.signals.NeutralModeValue;

import frc.Constants;
import frc.robot.Subsystems.Indexer.IndexerStates;

public class Shooter extends SubsystemBase{
    private static Shooter s_Shooter;
 
    private TalonFX m_Shooter;
    private TalonFX m_ShooterReverse;

    private Follower f = new Follower(Constants.HardwarePorts.m_IndexerLeader, true);

    public static Shooter getInstance() {
        if(s_Shooter == null) {
            s_Shooter = new Shooter();
        }
        return s_Shooter;
    }

    public Shooter() {
        m_Shooter = new TalonFX(Constants.HardwarePorts.m_Shooter);
        m_ShooterReverse = new TalonFX(Constants.HardwarePorts.m_ShooterReverse);

        m_ShooterReverse.setControl(f);
    }

    //All values are arbitrary for now feel free to change
    public enum ShooterStates {
        ON(0.5),
        OFF(0.0);

        private double speed;

        private ShooterStates(double state) {
            this.speed = state;
        }

        public double getSpeed() {
            return this.speed;
        }
    }

    private void configMotor(TalonFX fx) {
        TalonFXConfiguration configs = new TalonFXConfiguration();
        CurrentLimitsConfigs currentConfigs = new CurrentLimitsConfigs();    
        configs.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        currentConfigs.SupplyCurrentLimit = 8.0; //PLACEHOLDER
        fx.getConfigurator().apply(configs);
        fx.getConfigurator().apply(currentConfigs);
    }
    
    public void setSpeed(ShooterStates state) {
        //Arbitrary value
        m_Shooter.set(state.getSpeed());
    }

    public void setVoltage(double voltage) {
        m_Shooter.setVoltage(voltage);
    }


    public void periodic() {
        SmartDashboard.putData("Shooter motor", m_Shooter);
    }
}

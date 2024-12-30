package frc.robot.Subsystems;


import com.ctre.phoenix6.*;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.*;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants;

public class Intake extends SubsystemBase{
    private static Intake s_Intake;

    private TalonFX m_Intake;

    public static Intake getInstance() {
        if(s_Intake == null) {
            s_Intake = new Intake();
        }
        return s_Intake;
    }
    public Intake() {
        m_Intake = new TalonFX(Constants.HardwarePorts.m_IntakeLeader);

        configMotor(m_Intake);
    }

    //All values are arbitrary for now feel free to change

    public enum IntakeStates {
        ON(0.5),
        OFF(0.0),
        REVERSE(-0.5);

        private double speed;

        private IntakeStates(double state) {
            this.speed = state;
        }

        public double getSpeed() {
            return this.speed;
        }
    }

    private void configMotor(TalonFX fx) {
        TalonFXConfiguration configs = new TalonFXConfiguration();
        CurrentLimitsConfigs currentConfigs = new CurrentLimitsConfigs();    
        configs.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        currentConfigs.SupplyCurrentLimit = 8.0; //PLACEHOLDER
        fx.getConfigurator().apply(configs);
        fx.getConfigurator().apply(currentConfigs);
    }

    public void setSpeed(IntakeStates states) {
        m_Intake.set(states.getSpeed());
    }

    public void setVoltage(double voltage) {
        m_Intake.setVoltage(voltage);
    }

    public void periodic() {
        SmartDashboard.putData("Intake Motor", m_Intake);
    }
    
}

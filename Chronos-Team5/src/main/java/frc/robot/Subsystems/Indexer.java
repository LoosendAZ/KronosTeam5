package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.motorcontrol.Talon;

import com.ctre.phoenix6.*;
import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.*;
import edu.wpi.first.units.*;

import com.ctre.phoenix6.hardware.core.CoreTalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import frc.Constants;
import frc.robot.Subsystems.*;

public class Indexer extends SubsystemBase{
    private static Indexer s_Indexer;
    
    //As far as I remember there were 2 motors I could be wrong
    private TalonFX m_IndexerLeader;
    private TalonFX m_IndexerFollower;

    private Follower f = new Follower(Constants.HardwarePorts.m_IndexerLeader, false);

    public static Indexer getInstance() {
        if(s_Indexer == null) {
            s_Indexer = new Indexer();
        }
        return s_Indexer;
    }

    public Indexer() {
        m_IndexerLeader = new TalonFX(Constants.HardwarePorts.m_IndexerLeader);
        m_IndexerFollower = new TalonFX(Constants.HardwarePorts.m_IndexerFollower);

        m_IndexerFollower.setControl(f);
        configMotor(m_IndexerLeader);
        configMotor(m_IndexerFollower);
    }

    public enum IndexerStates {
        ON(0.5),
        OFF(0.0),
        REVERSE(-0.5);

        private double speed;

        private IndexerStates(double state) {
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

    public void setSpeed(IndexerStates states) {
        m_IndexerLeader.set(states.getSpeed());
    }

    public void setVoltage(double voltage) {
        //Arbitrary value
        m_IndexerLeader.setVoltage(voltage);
    }

    public void periodic() {
        SmartDashboard.putData("Indexer Motor", m_IndexerLeader);
    }
}

package frc.robot.Subsystems;


import com.ctre.phoenix6.*;
import com.ctre.phoenix6.hardware.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Constants;

public class Intake extends SubsystemBase{
    private Intake s_Intake;

    private TalonFX m_IntakeLeader;
    private TalonFX m_IntakeFollower;

    public Intake getInstance() {
        if(s_Intake == null) {
            s_Intake = new Intake();
        }
        return s_Intake;
    }
    public Intake() {
        m_IntakeLeader = new TalonFX(Constants.HardwarePorts.m_IntakeLeader);
        m_IntakeFollower = new TalonFX(Constants.HardwarePorts.m_IntakeFollower);
    }

    //All values are arbitrary for now feel free to change

    public enum IntakeStates {
        ON(1.0),
        OFF(0.0),
        REVERSE(-1.0);

        private double speed;

        private IntakeStates(double state) {
            this.speed = state;
        }

        public double getSpeed() {
            return this.speed;
        }
    }

    public void setVoltage(IntakeStates state) {
        m_IntakeLeader.setVoltage(state.getSpeed());
    }

    public void periodic() {
        SmartDashboard.putData("Intake Motor", m_IntakeLeader);
    }
    
}

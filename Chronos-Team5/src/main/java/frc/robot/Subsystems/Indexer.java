package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix6.*;
import com.ctre.phoenix6.hardware.TalonFX;

import frc.Constants;

public class Indexer extends SubsystemBase{
    private Indexer s_Indexer;
    
    //As far as I remember there were 2 motors I could be wrong
    private TalonFX m_IndexerLeader;
    private TalonFX m_IndexerFollower;

    public Indexer getInstance() {
        if(s_Indexer == null) {
            s_Indexer = new Indexer();
        }
        return s_Indexer;
    }

    public Indexer() {
        m_IndexerLeader = new TalonFX(Constants.HardwarePorts.m_IndexerLeader);
        m_IndexerFollower = new TalonFX(Constants.HardwarePorts.m_IndexerFollower);
        
    }

    //All values are arbitrary for now feel free to change

    public enum IndexerStates {
        ON(1.0),
        OFF(0.0),
        REVERSE(-1.0);

        private double speed;

        private IndexerStates(double state) {
            this.speed = state;
        }

        public double getSpeed() {
            return this.speed;
        }
    }

    public void setVoltage() {
        //Arbitrary value
        m_IndexerLeader.setVoltage(IndexerStates.ON.getSpeed());
    }

    public double getVoltage() {
        return -1.0;
    }

    public void periodic() {
        SmartDashboard.putData("Indexer Motor", m_IndexerLeader);
    }
}

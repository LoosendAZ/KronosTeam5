package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Indexer;
import frc.robot.Subsystems.Indexer.IndexerStates;

public class MoveIndexer extends Command{
    private Indexer s_Indexer;

    public MoveIndexer(Indexer indexer) {
        this.s_Indexer = indexer;
        addRequirements(s_Indexer);
    }

    public void initialize() {
        s_Indexer.setSpeed(IndexerStates.ON);
    }

    public void execute() {
        s_Indexer.setVoltage(12);
    }

    public void end(boolean b) {
        s_Indexer.setSpeed(IndexerStates.OFF);
        s_Indexer.setVoltage(0);
    }

    public boolean isFinished() {
        if(true) {

        }

        return false;
    }

}

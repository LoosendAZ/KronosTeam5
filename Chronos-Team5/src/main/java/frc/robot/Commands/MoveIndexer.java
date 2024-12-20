package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Indexer;
import frc.robot.Subsystems.Indexer.IndexerStates;

public class MoveIndexer extends Command{
    private Indexer s_Indexer;
    private Indexer.IndexerStates iState;

    public MoveIndexer(Indexer.IndexerStates iState) {
        this.s_Indexer = Indexer.getInstance();
        addRequirements(s_Indexer);
    }

    public void initialize() {
        s_Indexer.setSpeed(iState);
    }

    public void execute() {

    }

    public void end(boolean b) {
        s_Indexer.setSpeed(IndexerStates.OFF);
        s_Indexer.setVoltage(0);
    }

    public boolean isFinished() {
        //placeholder
        if(true) {
            return true;
        }

        return false;
    }

}

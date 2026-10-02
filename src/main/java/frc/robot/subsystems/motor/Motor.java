package frc.robot.subsystems.motor;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Motor extends SubsystemBase {

    private final MotorIO io;
    private final MotorIOInputsAutoLogged inputs = new MotorIOInputsAutoLogged();

    public Motor(MotorIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Motor", inputs);
    }

    public void runVolts(double volts) {
        io.runVolts(volts);
    }

    public void estop() {
        io.estop();
    }
}
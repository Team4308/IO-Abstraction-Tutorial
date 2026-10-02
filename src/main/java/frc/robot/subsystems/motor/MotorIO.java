package frc.robot.subsystems.motor;

import org.littletonrobotics.junction.AutoLog;
public interface MotorIO {

    @AutoLog
    public static class MotorIOInputs {
        public double position = 0.0;
        public double velocity = 0.0;
        public double appliedVolts = 0.0;
        public double currentAmps = 0.0;
    }

    void updateInputs(MotorIOInputs inputs);

    void runVolts(double volts);

    void estop();
}
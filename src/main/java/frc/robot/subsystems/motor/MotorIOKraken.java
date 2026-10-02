package frc.robot.subsystems.motor;

import com.ctre.phoenix6.hardware.TalonFX;

public class MotorIOKraken implements MotorIO {

    private final TalonFX motor = new TalonFX(31);

    @Override
    public void runVolts(double volts) {
        motor.setVoltage(volts);
    }

    @Override
    public void estop() {
        motor.stopMotor();
    }

    @Override
    public void updateInputs(MotorIOInputs inputs) {
        inputs.position = motor.getPosition().getValueAsDouble();
        inputs.velocity = motor.getVelocity().getValueAsDouble();
        inputs.appliedVolts = motor.getMotorVoltage().getValueAsDouble();
        inputs.currentAmps = motor.getStatorCurrent().getValueAsDouble();
    }
}
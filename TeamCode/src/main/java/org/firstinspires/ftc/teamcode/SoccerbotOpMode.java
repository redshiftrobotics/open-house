package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by ariporad on 2017-10-06.
 */

@TeleOp(name = "Soccerbot")
public class SoccerbotOpMode extends OpMode {
    DcMotor left;
    DcMotor right;

    @Override
    public void init() {
        left = hardwareMap.dcMotor.get("left_drive");
        right = hardwareMap.dcMotor.get("right_drive");
        left.setDirection(DcMotorSimple.Direction.REVERSE);
        right.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        if (gamepad2.left_trigger > 0.5 || gamepad2.right_trigger > 0.5) {
            left.setPower(gamepad2.left_stick_y);
            right.setPower(gamepad2.right_stick_y);
            telemetry.addLine("------------------------------");
            telemetry.addLine("ADMINISTRATIVE OVERRIDE ENABLED");
            telemetry.addLine("Visitor Driving Disabled");
            telemetry.addLine("------------------------------");
        } else {
            left.setPower(gamepad1.left_stick_y);
            right.setPower(gamepad1.right_stick_y);
        }
        telemetry.addLine("Welcome to Seattle Academy!");
        telemetry.update();
    }
}

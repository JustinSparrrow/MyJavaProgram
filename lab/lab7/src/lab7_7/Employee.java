package lab7_7;

public class Employee {
    private CompensationModel compensationModel;

    public Employee(CompensationModel compensationModel) {
        checkCompensationModel(compensationModel);
        this.compensationModel = compensationModel;
    }

    public void setCompensationModel(CompensationModel compensationModel) {
        checkCompensationModel(compensationModel);
        this.compensationModel = compensationModel;
    }

    public double earnings() {
        return compensationModel.earnings();
    }

    private void checkCompensationModel(CompensationModel compensationModel){
        if (!(compensationModel instanceof SalariedCompensationModel) &&
                !(compensationModel instanceof HourlyCompensationModel) &&
                !(compensationModel instanceof CommissionCompensationModel) &&
                !(compensationModel instanceof BasePlusCommissionCompensationModel)) {
            throw new IllegalArgumentException("错误模式");
        }
    }
}

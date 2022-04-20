package com.emeka.rabbit2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class InvoiceCancelledMessage {
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate canceledDate;
    private String invoiceNumber;
    private String reason;

    public InvoiceCancelledMessage(){}

    public InvoiceCancelledMessage(LocalDate canceledDate, String invoiceNumber, String reason) {
        this.canceledDate = canceledDate;
        this.invoiceNumber = invoiceNumber;
        this.reason = reason;
    }

    public LocalDate getCanceledDate() {
        return canceledDate;
    }

    public void setCanceledDate(LocalDate canceledDate) {
        this.canceledDate = canceledDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "InvoiceCancelledMessage{" +
                "canceledDate=" + canceledDate +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}

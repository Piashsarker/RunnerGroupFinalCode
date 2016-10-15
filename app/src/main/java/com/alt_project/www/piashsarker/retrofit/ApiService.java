package com.alt_project.www.piashsarker.retrofit;

import com.alt_project.www.piashsarker.List.AttendanceList;
import com.alt_project.www.piashsarker.List.ChargeHandOverList;
import com.alt_project.www.piashsarker.List.ContactList;
import com.alt_project.www.piashsarker.List.DistrictList;
import com.alt_project.www.piashsarker.List.InboxList;
import com.alt_project.www.piashsarker.List.LeaveDaysRequiredList;
import com.alt_project.www.piashsarker.List.LeaveReportList;
import com.alt_project.www.piashsarker.List.LeaveTypeList;
import com.alt_project.www.piashsarker.List.LoginList;
import com.alt_project.www.piashsarker.List.MonthList;
import com.alt_project.www.piashsarker.List.OnDutyList;
import com.alt_project.www.piashsarker.List.OnTourList;
import com.alt_project.www.piashsarker.List.OutboxList;
import com.alt_project.www.piashsarker.List.PendingLeaveList;
import com.alt_project.www.piashsarker.List.PendingOnDutyList;
import com.alt_project.www.piashsarker.List.PendingTourViewList;
import com.alt_project.www.piashsarker.List.ThanaList;
import com.alt_project.www.piashsarker.List.YearList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 08-Sep-16.
 */
public interface ApiService {

    @GET("login.aspx")
    Call<LoginList> getLoginDetails(
            @Query("key") String key,
            @Query("user") String user,
            @Query("pass") String pass);

    @GET("EmailServices.aspx")
    Call<InboxList> getInboxList(@Query("key") String key,
                                 @Query("type") String type,
                                 @Query("emp") Integer empId);

    @GET("EmailServices.aspx")
    Call<OutboxList> getOutboxList(@Query("key") String key,
                                   @Query("type") String type,
                                   @Query("emp") Integer empId);

    @GET("contacts.aspx")
    Call<ContactList> getContactList(@Query("key") String key);

    @GET("leave.aspx")
    Call<LeaveReportList> getLeaveReportList(@Query("key") String key,
                                             @Query("actionType") String actionType,
                                             @Query("empId") Integer empId);

    @GET("leave.aspx")
    Call<LeaveTypeList> getLeaveTypeList(@Query("key") String key,
                                         @Query("actionType") String actionType,
                                         @Query("empId") String empId);

    @GET("leave.aspx")
    Call<OnDutyList> getOnDutyList(@Query("key") String key,
                                   @Query("actionType") String actionType,
                                   @Query("empId") String empId);

    @GET("leave.aspx")
    Call<ChargeHandOverList> getChargeOver(@Query("key") String key,
                                           @Query("actionType") String actionType,
                                           @Query("empId") Integer empId);

    @GET("leave.aspx")
    Call<PendingLeaveList> getPendingLeave(@Query("key") String key,
                                           @Query("actionType") String actionType,
                                           @Query("empId") Integer empId);

    @GET("leave.aspx")
    Call<PendingOnDutyList> getPendingOnDuty(@Query("key") String key,
                                             @Query("actionType") String actionType,
                                             @Query("empId") Integer empId);

    @GET("leave.aspx")
    Call<PendingTourViewList> getPendingTour(@Query("key") String key,
                                             @Query("actionType") String actionType,
                                             @Query("empId") Integer empId);

    @GET("leave.aspx")
    Call<OnTourList> getTourReportList(@Query("key") String key,
                                       @Query("actionType") String actionType,
                                       @Query("empId") String empId);

    @GET("leave.aspx")
    Call<MonthList> getMonth(@Query("key") String key,
                             @Query("actionType") String actionType,
                             @Query("empId") String empId);

    @GET("leave.aspx")
    Call<ResponseBody> postPendingLeaveApproved(@Query("key") String key,
                                                @Query("actionType") String actionType,
                                                @Query("empId") String empId, @Query("applicationId") String applicationId);

    @GET("leave.aspx")
    Call<ResponseBody> postPendingLeaveReject(@Query("key") String key,
                                              @Query("actionType") String actionType,
                                              @Query("empId") String empId, @Query("applicationId") String applicationId);

    @GET("leave.aspx")
    Call<ResponseBody> postPendingTourReject(@Query("key") String key,
                                              @Query("actionType") String actionType,
                                              @Query("empId") String empId, @Query("tourid") String applicationId);

    @GET("leave.aspx")
    Call<ResponseBody> postPendingTourApproved(@Query("key") String key,
                                             @Query("actionType") String actionType,
                                             @Query("empId") String empId, @Query("tourid") String applicationId);
    @GET("leave.aspx")
    Call<ResponseBody> postPendingOnDutyApproved(@Query("key") String key,
                                               @Query("actionType") String actionType,
                                               @Query("empId") String empId, @Query("tourid") String applicationId);
    @GET("leave.aspx")
    Call<ResponseBody> postPendingOnDutyReject(@Query("key") String key,
                                               @Query("actionType") String actionType,
                                               @Query("empId") String empId, @Query("tourid") String applicationId);
    @GET("leave.aspx")
    Call<YearList> getYear(@Query("key") String key,
                           @Query("actionType") String actionType,
                           @Query("empId") String empId);

    @GET("attendance.aspx")
    Call<AttendanceList> getAttendanceList(@Query("key") String key, @Query("empId") String empId, @Query("YearId") String yearId
            , @Query("MonthId") String monthId);


    @POST("leave.aspx")
    Call<ResponseBody> postLeave(@Query("key") String key,
                                 @Query("actionType") String actionType,
                                 @Query("empId") String empId,
                                 @Query("fromDate")
                                 String fromDate,
                                 @Query("toDate")
                                 String toDate,
                                 @Query("leavePhone")
                                 String leavePhone,
                                 @Query("leaveType") Integer leaveType,
                                 @Query("purpose")
                                 String purpose,
                                 @Query("updatedBy")
                                 String updatedBy,
                                 @Query("handOver")
                                 String handOver);


    @POST("onDuty.aspx")
    Call<ResponseBody> postOnDuty(@Query("key") String key,
                                  @Query("EmployeeId") String EmployeeId,
                                  @Query("SubmissionDate")
                                  String SubmissionDate,
                                  @Query("FromDate") String FromDate,
                                  @Query("ToDate") String ToDate,
                                  @Query("Purpuse") String Purpose,
                                  @Query("UpdateBy") String UpdateBy,
                                  @Query("ApprovedBy")
                                  String ApprovedBy,
                                  @Query("ReportingTo") String ReportingTo);

    @POST("onTour.aspx")
    Call<ResponseBody> postOnTour(@Query("key") String key,
                                  @Query("EmployeeId") String EmployeeId,
                                  @Query("SubmissionDate")
                                  String SubmissionDate,
                                  @Query("FromDate") String FromDate,
                                  @Query("ToDate") String ToDate,
                                  @Query("Purpuse") String Purpose,
                                  @Query("UpdateBy") String UpdateBy,
                                  @Query("ApprovedBy")
                                  String ApprovedBy,
                                  @Query("ReportingTo") String ReportingTo,
                                  @Query("areaId")String areaId);

    @POST("EmailServices.aspx")
    Call<ResponseBody> postMessage(@Query("key") String key, @Query("type") String type, @Query("from") String from, @Query("to") String to, @Query("subject") String subject,
                                   @Query("msg") String msg);

    @GET("leave.aspx")
    Call<DistrictList> getDistrict (@Query("key") String key,
                                    @Query("actionType") String actionType,
                                    @Query("empId") String empId);
    @GET("leave.aspx")
    Call<ThanaList> getThana (@Query("key") String key,
                              @Query("actionType") String actionType,
                              @Query("empId") String empId,
                              @Query("districtId")String districtId);
    @POST("EmailServices.aspx")
    Call<ResponseBody> postReadStatus(@Query("key") String key ,
                                      @Query("type")String type,
                                      @Query("employeeMailId") String employeeMailId);


    @GET("leave.aspx")
    Call<LeaveDaysRequiredList> getLeaveDays (@Query("key") String key,
                                              @Query("actionType") String actionType,
                                              @Query("empId") String empId,
                                              @Query("leavetypeId")Integer leaveTypeId,
                                              @Query("fromdate")String fromdate,
                                              @Query("todate")String todate);

}

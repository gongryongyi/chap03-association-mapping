package com.ohgiraffers.section02.column;

import javax.persistence.*;
import java.util.Date;

@Entity(name="member_section02")
@Table(name="tbl_member_section02")
public class Member {
    @Id
    @Column(name="member_no")
    private int memberNo;
    @Column(name="member_id", length = 20)
    private String memberId;
    @Column(name="member_pwd")
    private String memberPwd;
    @Column(name="nickname")
    @Transient  // 테이블과의 매핑에서 (nickname)무시하겠다
    private String nickname;
    @Column(name="phone", columnDefinition = "varchar2(200) default '010-0000-0000'")  // columnDefinition = 그 컬럼을 내가 이렇게 설정하겠습니다. (속성 설정)
    private String phone;
    @Column(name="email", unique = true)  //unique = 이메일은 반드시 고유값이여야 한다.
    private String email;
    @Column(name="address", nullable = false)  //nullable = 반드시 입력되야한다.
    private String address;
    @Column(name="enroll_date")
    @Temporal(TemporalType.TIMESTAMP)  // DATE + TIME : 날짜 및 시간
    //@Temporal(TemporalType.DATE) // 오라클에서는 TIMESTAMP와 동일
    //@Temporal(TemporalType.TIME)  // 1970/01/01에 시간만 맞게 나옴 즉 날짜는 다루지 않고 시간만 다루겠다.
    private Date enrollDate;
    @Column(name="member_role")
    private String memberRole;
    @Column(name="status")
    private String status;
    public Member() {}
    public Member(int memberNo, String memberId, String memberPwd, String nickname, String phone,
                  String email, String address, Date enrollDate, String memberRole, String status) {
        super();
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRole = memberRole;
        this.status = status;
    }
    public int getMemberNo() {
        return memberNo;
    }
    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getMemberPwd() {
        return memberPwd;
    }
    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Date getEnrollDate() {
        return enrollDate;
    }
    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }
    public String getMemberRole() {
        return memberRole;
    }
    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPwd=" + memberPwd
                + ", nickname=" + nickname + ", phone=" + phone + ", email=" + email
                + ", address=" + address + ", enrollDate=" + enrollDate + ", memberRole=" + memberRole
                + ", status=" + status + "]";
    }
}


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <jsp:include page="../header.jsp" />
    
    <section class="content-header">
        <h1>Панель администратора</h1>
        <span></span>
    </section>
    
    <section class="content">
        <div class="box">
            <div class="box-header with-border">
                <h3 class="box-title">Меню</h3>
            </div>
            <div class="box-body">
                <table class="table table-hover table-bordered table-striped ">
                    <tr>
                        <td>1</td>
                        <td><a href="adminUsers">Пользователи</a></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td><a href="adminPartners">Партнеры</a></td>
                    </tr>
                </table>
            </div>
        </div>
    </section>
    
    <%@include file="../footer.jsp" %>
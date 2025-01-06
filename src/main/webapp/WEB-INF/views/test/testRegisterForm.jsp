<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2025-01-06-월요일
  Time: 오후 9:19
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Address Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card">
        <div class="card-header text-center bg-secondary text-white">
            <h4>주소 입력 폼</h4>
        </div>
        <div class="card-body">
            <form>
                <!-- 우편번호와 검색 버튼 -->
                <div class="row mb-3">
                    <div class="col-md-3">
                        <label for="postalCode" class="form-label">우편번호</label>
                        <input type="text" id="postalCode" class="form-control" placeholder="우편번호를 입력하세요" readonly>
                    </div>
                    <div class="col-md-1 d-flex align-items-end">
                        <button type="button" class="btn btn-dark w-100">검색</button>
                    </div>
                </div>

                <!-- 도로명 주소, 지번 주소, X 좌표, Y 좌표 -->
                <div class="row mb-3">
                    <div class="col-md-4">
                        <label for="roadAddress" class="form-label">도로명 주소</label>
                        <input type="text" id="roadAddress" class="form-control" placeholder="도로명 주소를 입력하세요" readonly>
                    </div>
                    <div class="col-md-4">
                        <label for="jibunAddress" class="form-label">지번 주소</label>
                        <input type="text" id="jibunAddress" class="form-control" placeholder="지번 주소를 입력하세요" readonly>
                    </div>
                    <div class="col-md-2">
                        <label for="xCoordinate" class="form-label">X 좌표</label>
                        <input type="text" id="xCoordinate" class="form-control" placeholder="X 좌표" readonly>
                    </div>
                    <div class="col-md-2">
                        <label for="yCoordinate" class="form-label">Y 좌표</label>
                        <input type="text" id="yCoordinate" class="form-control" placeholder="Y 좌표" readonly>
                    </div>
                </div>

                <!-- 상세 주소 -->
                <div class="mb-3">
                    <label for="detailAddress" class="form-label">상세 주소</label>
                    <input type="text" id="detailAddress" class="form-control" placeholder="상세 주소를 입력하세요">
                </div>

                <!-- 핸드폰 번호 -->
                <div class="row mb-3">
                    <div class="col-md-6">
                        <label for="ceoName" class="form-label"><span class="text-danger">*</span>대표자 이름</label>
                        <input type="text" id="ceoName" class="form-control" placeholder="대표자 이름을 입력하세요" required>
                    </div>
                    <div class="col-md-6">
                        <label for="phoneNumber" class="form-label"><span class="text-danger">*</span>대표자 핸드폰 번호</label>
                        <input type="text" id="phoneNumber" class="form-control" placeholder="000-0000-0000" pattern="\d{3}-\d{4}-\d{4}" required>
                    </div>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-primary">저장</button>
                    <button type="reset" class="btn btn-secondary">초기화</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
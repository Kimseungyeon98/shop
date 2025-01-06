<%--
  Created by IntelliJ IDEA.
  User: Kimseungyeon
  Date: 2025-01-06-월요일
  Time: 오후 9:54
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>목록 조회</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <!-- Search Form -->
    <form class="row g-2 mb-4 pb-4 d-flex justify-content-center form-control">
        <h4 class="text-center">병원 검색</h4>
        <div class="col-md-2">
            <label for="medicalSubject" class="form-label"></label>
            <select id="medicalSubject" class="form-select">
                <option value="">진료과목</option>
                <option value="내과">내과</option>
                <option value="외과">외과</option>
                <option value="소아과">소아과</option>
                <!-- 추가 진료과목 옵션 -->
            </select>
        </div>
        <div class="col-md-2">
            <label for="category" class="form-label"></label>
            <select id="category" class="form-select">
                <option value="">카테고리</option>
                <option value="지역">지역</option>
                <option value="병원명">병원명</option>
            </select>
        </div>
        <div class="col-md-4">
            <label for="searchText" class="form-label"></label>
            <input type="text" id="searchText" class="form-control" placeholder="검색어를 입력하세요">
        </div>
        <div class="col-md-1 d-flex align-items-end">
            <button type="submit" class="btn btn-secondary w-100">검색</button>
        </div>
        <div class="col-md-1 d-flex align-items-end">
            <button type="reset" class="btn btn-secondary w-100">초기화</button>
        </div>
    </form>
    <div class="card">
        <div class="card-header bg-primary text-white text-center">
            <h4>병원 목록 조회</h4>
        </div>
        <div class="card-body">
            <!-- Card Style List -->
            <div class="row g-3">
                <div class="col-md-4">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h5 class="card-title">샘플 제목 1</h5>
                            <p class="card-text mb-1"><strong>전화번호:</strong> 010-1234-5678</p>
                            <p class="card-text mb-1"><strong>대표자 이름:</strong> 홍길동</p>
                            <p class="card-text"><strong>날짜:</strong> 2025-01-06</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h5 class="card-title">샘플 제목 2</h5>
                            <p class="card-text mb-1"><strong>전화번호:</strong> 010-2345-6789</p>
                            <p class="card-text mb-1"><strong>대표자 이름:</strong> 김철수</p>
                            <p class="card-text"><strong>날짜:</strong> 2025-01-05</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h5 class="card-title">샘플 제목 3</h5>
                            <p class="card-text mb-1"><strong>전화번호:</strong> 010-3456-7890</p>
                            <p class="card-text mb-1"><strong>대표자 이름:</strong> 이영희</p>
                            <p class="card-text"><strong>날짜:</strong> 2025-01-04</p>
                        </div>
                    </div>
                </div>
                <!-- 추가 데이터 카드는 여기에 삽입 -->
            </div>

            <!-- Pagination -->
            <nav aria-label="Page navigation" class="mt-4">
                <ul class="pagination justify-content-center">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">이전</a>
                    </li>
                    <li class="page-item active">
                        <a class="page-link" href="#">1</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">2</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">3</a>
                    </li>
                    <li class="page-item">
                        <a class="page-link" href="#">다음</a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

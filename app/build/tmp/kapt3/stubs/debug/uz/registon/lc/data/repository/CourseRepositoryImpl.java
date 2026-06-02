package uz.registon.lc.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0096@\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Luz/registon/lc/data/repository/CourseRepositoryImpl;", "Luz/registon/lc/domain/repository/CourseRepository;", "apiService", "Luz/registon/lc/data/remote/ApiService;", "(Luz/registon/lc/data/remote/ApiService;)V", "getCourseById", "Luz/registon/lc/domain/model/Course;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCourses", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CourseRepositoryImpl implements uz.registon.lc.domain.repository.CourseRepository {
    @org.jetbrains.annotations.NotNull()
    private final uz.registon.lc.data.remote.ApiService apiService = null;
    
    public CourseRepositoryImpl(@org.jetbrains.annotations.NotNull()
    uz.registon.lc.data.remote.ApiService apiService) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCourses(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<uz.registon.lc.domain.model.Course>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCourseById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super uz.registon.lc.domain.model.Course> $completion) {
        return null;
    }
}
package uz.registon.lc.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u00a7@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Luz/registon/lc/data/remote/ApiService;", "", "getCourseDetails", "Luz/registon/lc/domain/model/Course;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCourses", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.GET(value = "courses")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCourses(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<uz.registon.lc.domain.model.Course>> $completion);
    
    @retrofit2.http.GET(value = "courses/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCourseDetails(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super uz.registon.lc.domain.model.Course> $completion);
}
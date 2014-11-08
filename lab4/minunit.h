// Matthew Kim
// madkim
// cmps12b
// 11/7/14
// minunit.h
// runs unit tests for queue.c 

/* file: minunit.h */
/* C unit testing in 7 lines of preprocessor code. */
#define STR(x) #x
#define STRINGIFY(x) STR(x)
#define FILE_LINE __FILE__ ":" STRINGIFY(__LINE__) " --- "
#define mu_assert(message, test) do { if (!(test)) return FILE_LINE message; } while (0)
#define mu_run_test(test) do { char *message = test(); tests_run++; \
                               if (message) return message; } while (0)
extern int tests_run;

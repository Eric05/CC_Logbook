package limitOutput;

public class Employee implements Comparable<Employee> {

        private Long id;
        private String name;

        public Employee(long l, String name) {
            this.id = l;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Employee employee) {
            return (int)(this.id - employee.getId());
        }
}

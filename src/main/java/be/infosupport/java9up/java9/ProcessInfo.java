package be.infosupport.java9up.java9;

public class ProcessInfo {
    private String command;
    private long processId;

    public static class Builder {

        private String command;
        private long processId;

        public Builder() {
        }

        public Builder command(String command) {
            this.command = command;

            return this;
        }

        public Builder processId(long processId) {
            this.processId = processId;

            return this;
        }

        public ProcessInfo build() {
            var processInfo = new ProcessInfo();

            processInfo.command = this.command;
            processInfo.processId = this.processId;

            return processInfo;
        }
    }

    private ProcessInfo() {
    }

    public String getCommand() {
        return command;
    }

    public long getProcessId() {
        return processId;
    }
}
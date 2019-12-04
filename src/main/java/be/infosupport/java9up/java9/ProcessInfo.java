package be.infosupport.java9up.java9;

class ProcessInfo {
    private String command;
    private long processId;

    static class Builder {

        private String command;
        private long processId;

        Builder() {
        }

        Builder command(String command) {
            this.command = command;

            return this;
        }

        Builder processId(long processId) {
            this.processId = processId;

            return this;
        }

        ProcessInfo build() {
            var processInfo = new ProcessInfo();

            processInfo.command = this.command;
            processInfo.processId = this.processId;

            return processInfo;
        }
    }

    private ProcessInfo() {
    }

    String getCommand() {
        return command;
    }

    long getProcessId() {
        return processId;
    }
}
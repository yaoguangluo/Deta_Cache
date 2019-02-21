package org.lyg.common.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LinuxServerUtil {

    /**
     * 获取cpu使用情况
     * @return
     * @throws Exception
     */
    public static double getCpuUsage() throws Exception {
        double cpuUsed = 0;

        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("top -b -n 1");// 调用系统的“top"命令

        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String str = null;
            String[] strArray = null;

            while ((str = in.readLine()) != null) {
                int m = 0;

                if (str.indexOf(" R ") != -1) {// 只分析正在运行的进程，top进程本身除外 &&

                    strArray = str.split(" ");
                    for (String tmp : strArray) {
                        if (tmp.trim().length() == 0) {
                            continue;
                        }
                        if (++m == 9) {// 第9列为cpu的使用百分比(RedHat

                            cpuUsed += Double.parseDouble(tmp);

                        }

                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
        return cpuUsed;
    }

    /**
     * 内存监控
     * @return
     * @throws Exception
     */
    public static double getMemUsage() throws Exception {

        double menUsed = 0;
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("top -b -n 1");// 调用系统的“top"命令

        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String str = null;
            String[] strArray = null;

            while ((str = in.readLine()) != null) {
                int m = 0;

                if (str.indexOf(" R ") != -1) {// 只分析正在运行的进程，top进程本身除外 &&
                    //
                    // System.out.println("------------------3-----------------");
                    strArray = str.split(" ");
                    for (String tmp : strArray) {
                        if (tmp.trim().length() == 0) {
                            continue;
                        }

                        if (++m == 10) {
                            // 9)--第10列为mem的使用百分比(RedHat 9)

                            menUsed += Double.parseDouble(tmp);

                        }
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
        return menUsed;
    }


    /**
     * 获取磁盘信息
     * @return
     */
    public static Disk getDiskUsage() {
        Disk desk = new Disk();
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("df -hl");// df -hl 查看硬盘空间
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(
                        p.getInputStream()));
                String str = null;
                String[] strArray = null;
                int line = 0;
                while ((str = in.readLine()) != null) {
                    line++;
                    if (line != 2) {
                        continue;
                    }
                    int m = 0;
                    strArray = str.split(" ");
                    for (String para : strArray) {
                        if (para.trim().length() == 0) {
                            continue;
                        }
                        ++m;
                        if (para.endsWith("G") || para.endsWith("Gi")) {
                            // 目前的服务器
                            if (m == 2) {
                                desk.setTotal(para);
                            }
                            if (m == 3) {
                                desk.setUsed(para);
                            }
                        }
                        if (para.endsWith("%")) {
                            if (m == 5) {
                                desk.setUse_rate(para);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                in.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return desk;
    }

    public static class Disk {
        private String total;
        private String used;
        private String use_rate;

        @Override
        public String toString(){
            return "TotalDisk "+total+", UsedDisk "+used+", DiskRatio "+use_rate;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getUsed() {
            return used;
        }

        public void setUsed(String used) {
            this.used = used;
        }

        public String getUse_rate() {
            return use_rate;
        }

        public void setUse_rate(String use_rate) {
            this.use_rate = use_rate;
        }

    }


    public static String getLinuxServerStatus() throws Exception {

        Runtime lRuntime = Runtime.getRuntime();
        StringBuffer runtimeMemory=new StringBuffer();
        runtimeMemory.append("--------------Free Momery:" + lRuntime.freeMemory()/1024/1024+"G");
        runtimeMemory.append("--------------Max Momery:" + lRuntime.maxMemory()/1024/1024+"G");
        runtimeMemory.append("--------------Total Momery:" + lRuntime.totalMemory()/1024/1024+"G");
        runtimeMemory.append("--------------Available Processors:"
                + lRuntime.availableProcessors());

        return "CpuInfo "+getCpuUsage()+"%, MemoryInfo "+getMemUsage()+", DiskInfo "+getDiskUsage()+"\r\n"+
        runtimeMemory.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("---------------cpu used:" + getCpuUsage() + "%");
        System.out.println("---------------mem used:" + getMemUsage() + "%");
        System.out.println("---------------disk info:" + getDiskUsage() + "%");
        System.out.println("---------------jvm monitor---------------");
        Runtime lRuntime = Runtime.getRuntime();
        System.out.println("--------------Free Momery:" + lRuntime.freeMemory()/1024/1024+"G");
        System.out.println("--------------Max Momery:" + lRuntime.maxMemory()/1024/1024+"G");
        System.out.println("--------------Total Momery:" + lRuntime.totalMemory()/1024/1024+"G");
        System.out.println("--------------Available Processors:"
                + lRuntime.availableProcessors());
    }
}

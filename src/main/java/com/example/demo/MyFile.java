package com.example.demo;

  class MyFile1 {
        public String name;
        public int year;

        public String getName() {
            return name;
        }

        public int getYear() {
            return year;
        }

        public String getFormat() {
            return format;
        }

        public String format;
        public String parent;
        public String dir;

        public MyFile1(String d,String parent , String dir) {
            String[] dd = d.split("\\.");
            this.name = dd[0];
            this.year = Integer.parseInt(dd[1]);
            this.format = dd[2];
            this.parent=parent;
            this.dir = dir;
            System.out.println(dd[0]);
        }

    }

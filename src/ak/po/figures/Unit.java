package ak.po.figures;

    public enum Unit {
        MILIMETRY("mm"),
        CENTYMETRY("cm"),
        DECYMETRY("dm"),
        METRY("m");
        private String shortCut;

        private Unit(String sc) {
            this.shortCut = sc;
        }

        @Override
        public String toString() {
            return shortCut;
        }
    }

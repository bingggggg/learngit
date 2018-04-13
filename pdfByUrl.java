/** 从路径获取html页面直接转成pdf */
	@RequestMapping("/test")
	public void test(HttpServletResponse response) throws IOException, DocumentException {

		Document document = new Document();
		response.setHeader("Content-Disposition", "attachment; filename=\"" + "Cdfvfdv.pdf" + "\"");
		response.setContentType("application/pdf");
		OutputStream os = response.getOutputStream();
		PdfWriter pdfwriter = PdfWriter.getInstance(document, os);
		pdfwriter.setViewerPreferences(PdfWriter.HideToolbar);
		document.open();
		URL url = new java.net.URL("http://120.25.229.93:1221/findPaySettlementGroup?menuNo=3");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		InputStreamReader isr = new InputStreamReader(conn.getInputStream(), "UTF-8");
		XMLWorkerHelper.getInstance().parseXHtml(pdfwriter, document, isr);
		document.close();
		os.flush();
		os.close();

	}